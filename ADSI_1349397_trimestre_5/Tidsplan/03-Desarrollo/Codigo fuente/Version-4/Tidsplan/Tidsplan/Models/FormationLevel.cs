using System;
using System.Collections.Generic;
using System.ComponentModel.DataAnnotations;
using System.ComponentModel.DataAnnotations.Schema;
using System.Linq;
using System.Web;

namespace Tidsplan.Models
{
    public class FormationLevel
    {
        [Key]
        public int idFormationLvel { get; set; }

        [Display(Name = "Nivel de formación")]
        [Required(ErrorMessage = "Es requerido.")]
        [StringLength(30, ErrorMessage = "Debe tener mínimo dos caracteres, máximo treinta caracteres.", MinimumLength = 2)]
        [Index("FormationLevel_LevelFormation_Index", IsUnique = true)]
        public String LevelFormation { get; set; }

        [Required(ErrorMessage = "Es requerido.")]
        [Display(Name = "Nivel de formación")]
        public String toUpper
        {
            get
            {
                if (LevelFormation != null)
                {
                    LevelFormation = LevelFormation.ToUpper();
                }
                else
                {
                    LevelFormation = "Es requerido.";
                }
                return LevelFormation;
            }
            set
            {
                if (LevelFormation != null)
                {
                    LevelFormation = LevelFormation.ToUpper();
                }
                else
                {
                    LevelFormation = "Es requerido.";
                }
                LevelFormation.ToUpper();
            }
        }

        public virtual ICollection<Trimester> trimester { get; set; }
    }
}