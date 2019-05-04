using System;
using System.Collections.Generic;
using System.ComponentModel.DataAnnotations;
using System.ComponentModel.DataAnnotations.Schema;
using System.Linq;
using System.Web;

namespace Tidsplan.Models
{
    public class TrainingProgram
    {
        [Key]
        public int idTrainingProgram { get; set; }


        [Display(Name = "Código de programa")]
        [Required(ErrorMessage = "Es requerido.")]
        [RegularExpression("^[0-9]*$", ErrorMessage = "Solo se admiten números.")]
        [StringLength(30, ErrorMessage = "Debe tener mínimo dos caracteres, máximo treinta caracteres.", MinimumLength = 2)]
        [Index("TrainingProgram_idCode_Index", IsUnique = true)]
        public String idCode { get; set; }


        [Display(Name = "Nombre de programa")]
        [Required(ErrorMessage = "Es requerido.")]
        [StringLength(30, ErrorMessage = "Debe tener mínimo dos caracteres, máximo treinta caracteres.", MinimumLength = 2)]
        [Index("TrainingProgram_nameProgram_Index", IsUnique = true)]
        public String nameProgram { get; set; }

        [Required(ErrorMessage = "Es requerido.")]
        [Display(Name = "Nombre de programa")]
        public String toUpper
        {
            get
            {
                if (nameProgram != null)
                {
                    nameProgram = nameProgram.ToUpper();
                }
                else
                {
                    nameProgram = "Es requerido.";
                }
                return nameProgram;
            }
            set
            {
                if (nameProgram != null)
                {
                    nameProgram = nameProgram.ToUpper();
                }
                else
                {
                    nameProgram = "Es requerido.";
                }
                nameProgram.ToUpper();
            }
        }


        [Display(Name = "Versión del programa")]
        [RegularExpression("^[0-9]*$", ErrorMessage = "Solo se admiten números.")]
        [Required(ErrorMessage = "Es requerido.")]
        [StringLength(30, ErrorMessage = "Debe tener mínimo dos caracteres, máximo treinta caracteres.", MinimumLength = 2)]
        [Index("TrainingProgram_version_Index", IsUnique = true)]
        public String version { get; set; }


        [Display(Name = "Iniciales del programa")]
        [Required(ErrorMessage = "Es requerido.")]
        [StringLength(3, ErrorMessage = "Debe tener mínimo un caracter, máximo tres caracteres.", MinimumLength = 1)]
        [Index("TrainingProgram_initials_Index", IsUnique = true)]
        public String initials { get; set; }

        [Required(ErrorMessage = "Es requerido.")]
        [Display(Name = "Iniciales del programa")]
        public String toUpper2
        {
            get
            {
                if (initials != null)
                {
                    initials = initials.ToUpper();
                }
                else
                {
                    initials = "Es requerido.";
                }
                return initials;
            }
            set
            {
                if (initials != null)
                {
                    initials = initials.ToUpper();
                }
                else
                {
                    nameProgram = "Es requerido.";
                }
                initials.ToUpper();
            }
        }

        public virtual ICollection<Trimester> trimesters { get; set; }
    }
}