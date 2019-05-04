using System;
using System.Collections.Generic;
using System.ComponentModel.DataAnnotations;
using System.ComponentModel.DataAnnotations.Schema;
using System.Linq;
using System.Web;

namespace Tidsplan.Models
{
    public class Speciality
    {
        [Key]
        public int idSpeciality { get; set; }

        [Required(ErrorMessage = "Es requerido.")]
        [Display(Name = "Nombre de especialidad")]
        [StringLength(30, ErrorMessage = "Debe tener mínimo dos caracteres, máximo treinta caracteres.", MinimumLength =2)]
        [Index ("Speciality_nameSpeciality_Index",IsUnique = true)]
        public String nameSpeciality { get; set; }


        [Required(ErrorMessage = "Es requerido.")]
        [Display(Name = "Nombre de especialidad")]
        public String toUpper
        {           
            get
            {             
                if (nameSpeciality != null) {
                    nameSpeciality= nameSpeciality.ToUpper();
                }
                else
                {
                    nameSpeciality="este campo es requerido.";
                }
                return nameSpeciality;
            }
            set
            {
                if (nameSpeciality != null)
                {
                    nameSpeciality = nameSpeciality.ToUpper();
                }
                else
                {
                    nameSpeciality = "este campo es requerido.";
                }
                nameSpeciality.ToUpper();
            }
        }

        public virtual ICollection<Instructor> instructors { get; set; }
    }
}