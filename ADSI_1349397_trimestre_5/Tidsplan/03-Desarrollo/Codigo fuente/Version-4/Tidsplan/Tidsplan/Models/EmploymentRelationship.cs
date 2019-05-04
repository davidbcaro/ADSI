using System;
using System.Collections.Generic;
using System.ComponentModel.DataAnnotations;
using System.ComponentModel.DataAnnotations.Schema;
using System.Linq;
using System.Web;

namespace Tidsplan.Models
{
    public class EmploymentRelationship
    {

        [Key]
        public int idEmploymentRelationship { get; set; }

        [Required(ErrorMessage = "Es requerido.")]
        [Display(Name = "Tipo de vinculación")]
        [StringLength(30, ErrorMessage = "Debe tener mínimo dos caracteres, máximo treinta caracteres.", MinimumLength = 2)]
        [Index("EmploymentRelationship_typeEmploymentRelationship_Index", IsUnique = true)]
        public String typeEmploymentRelationship { get; set; }

        [Required(ErrorMessage = "Es requerido.")]
        [Display(Name = "Horas de trabajo")]
        public int hours { get; set; }

        [Required(ErrorMessage = "Es requerido.")]
        [Display(Name = "Tipo de vinculación")]
        public String toUpper
        {
            get
            {
                if (typeEmploymentRelationship != null)
                {
                    typeEmploymentRelationship = typeEmploymentRelationship.ToUpper();
                }
                else
                {
                    typeEmploymentRelationship = "Es requerido.";
                }
                return typeEmploymentRelationship;
            }
            set
            {
                if (typeEmploymentRelationship != null)
                {
                    typeEmploymentRelationship = typeEmploymentRelationship.ToUpper();
                }
                else
                {
                    typeEmploymentRelationship = "Es requerido.";
                }
                typeEmploymentRelationship.ToUpper();
            }
        }

        public virtual ICollection<Instructor> instructors { get; set; }

    }
}